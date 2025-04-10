package br.com.yasmine.projeto_servidor_lotacao.aws;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.tools.FileObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import software.amazon.awssdk.services.s3.S3Client;

@Service
public class FileService {
	
	@Autowired
	private S3Client s3client;
	
	@Value("${aws.bucket-name}")
	private String bucketName;
	
	@Value("${aws.endpoint}")
	private String endpoint;
	
	public String uploadFile(MultipartFile file, String entityFile, String fileUri) {
		String fileName = entityFile = fileUri;
		File fileObj = convertMultiPartFileToFile(file);
		
		PutObjectRequest objectRequest = PutObjectRequest.builder().bucket(bucketName).key(fileName).build();
		
		s3client.putObject(objectRequest, fileObj.toPath());
		
		return endpoint + "/" + bucketName + "/" + fileName;
	}
	
	private File convertMultiPartFileToFile(MultipartFile file) {
		File convertedFile = new File(file.getOriginalFilename());
		
		try(FileOutputStream fos = new FileOutputStream(convertedFile)){
			fos.write(file.getBytes());
		}catch (IOException e) {
			e.printStackTrace();
		}
		return convertedFile;
	}

}
