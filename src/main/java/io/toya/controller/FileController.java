package io.toya.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileController {

    private String fileDirPath = "/WEB-INF/files";

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
        String pathStr = request.getServletContext().getRealPath(fileDirPath);
        File fileDir = new File(pathStr);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        List<String> fileList = new ArrayList<>();
        for (File file : fileDir.listFiles()) {
            fileList.add(file.getName());
        }
        model.addAttribute("fileList", fileList);
        return "file/index";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request,
                         @RequestParam("file") MultipartFile file,
                         RedirectAttributes redirectAttributes) {
        if (file == null && file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "文件为空");
        } else {
            String pathStr = request.getServletContext().getRealPath(fileDirPath);
            File filePath = new File(pathStr, file.getOriginalFilename());
            if (!filePath.getParentFile().exists()) {
                filePath.mkdir();
            }
            try {
                file.transferTo(filePath);
                redirectAttributes.addFlashAttribute("message", "上传文件成功");
            } catch (IOException e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute("message", "上传文件失败");
            }
        }
        return "redirect:/file/index";
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> download(String filename,
                                           @RequestHeader("User-Agent") String userAgent,
                                           HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath(fileDirPath);
        File file = new File(path, filename);

        ResponseEntity.BodyBuilder bodyBuilder = ResponseEntity.ok();
        bodyBuilder.contentLength(file.length());
        bodyBuilder.contentType(MediaType.APPLICATION_OCTET_STREAM);


        filename = URLEncoder.encode(filename, "UTF-8");

        if (userAgent.contains("MSIE")) {
            bodyBuilder.header("Content-Disposition", "attachment; filename=" + filename);
        } else {
            bodyBuilder.header("Content-Disposition", "attachment; filename*=UTF-8''" + filename);
        }

        ResponseEntity responseEntity = bodyBuilder.body(FileUtils.readFileToByteArray(file));
        return responseEntity;
    }
}
