package ru.hogwarts.scool8.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.scool8.model.Avatar;
import ru.hogwarts.scool8.model.Student;
import ru.hogwarts.scool8.repository.AvatarRepository;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
@Transactional
public class AvatarService {
    private final Logger logger= LoggerFactory.getLogger(AvatarService.class);
    @Value("${students.avatar.dir.path}")
    private String avatarsDir;

    private final StudentService studentService;
    private final AvatarRepository avatarRepository;


    public AvatarService(StudentService studentService, AvatarRepository avatarRepository) {
        this.studentService = studentService;
        this.avatarRepository = avatarRepository;

    }

    public void uploadAvatar(Long studentId, MultipartFile file) throws IOException {
        logger.debug("upload avatar:{}",studentId, file);
        Student student = studentService.findStudent(studentId);

        Path filePath = Path.of(avatarsDir, studentId + "." + getExtension(file.getOriginalFilename()));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);

        try (InputStream is = file.getInputStream();
             OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
             BufferedInputStream bis = new BufferedInputStream(is, 1024);
             BufferedOutputStream bos = new BufferedOutputStream(os, 1024);

        ) {
            bis.transferTo(bos);
        }
        Avatar avatar = findAvatar(studentId);
        // Avatar avatar = avatarRepository.findByStudentId(studentId).orElseGet(Avatar::new);
        avatar.setStudent(student);
        avatar.setFilePath(filePath.toString());
        avatar.setFileSize(file.getSize());
        avatar.setMediaType(file.getContentType());
        avatar.setData(generateImageDate(filePath));
        //        avatar.setData(file.getBytes());

        avatarRepository.save(avatar);
    }

    public Avatar findAvatar(Long studentId) {
        logger.debug("find avatar:{}",studentId);
        final var avatar = avatarRepository.findByStudentId(studentId).orElse(new Avatar());
        logger.debug("find is the avatar{}", avatar);
        return avatar;
        //   return avatarRepository.findByStudentId(studentId).orElseThrow();
    }

    private String getExtension(String fileName) {
        logger.debug("get extension:{}",fileName);
        final var substring = fileName.substring(fileName.lastIndexOf(".") + 1);
        logger.debug("get this extension{}", substring);
        return substring;
    }

    private byte[] generateImageDate(Path filePath) throws IOException {
        logger.debug("We generate Image Date:{}",filePath);
        try (InputStream is = Files.newInputStream(filePath);
             BufferedInputStream bis = new BufferedInputStream(is, 1024);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            BufferedImage image = ImageIO.read(bis);

            int height = image.getHeight() / (image.getWidth() / 100);
            BufferedImage data = new BufferedImage(100, height, image.getType());
            Graphics2D graphics = data.createGraphics();
            graphics.drawImage(image, 0, 0, 100, height, null);
            graphics.dispose();

            ImageIO.write(data, getExtension(filePath.getFileName().toString()), baos);
            return baos.toByteArray();

        }
    }

    public List<Avatar> getAllAvatar(Integer pageNumber, Integer pageSize) {
        logger.debug("We getting all avatare:{}",pageNumber,pageSize);
        PageRequest pageRequest=PageRequest.of(pageNumber-1,pageSize);
        return avatarRepository.findAll(pageRequest).getContent();
    }
}
