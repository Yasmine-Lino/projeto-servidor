package br.com.yasmine.projeto_servidor_lotacao.aws;

import java.awt.Dialog;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;**/

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@Slf4j
//@Component
//@RequiredArgsConstructor
public class AWSService {

	
/**	private final AmazonS3 amazonS3Client = AmazonS3Client.builder().withCredentials(new DefaultAWSCredentialsProviderChain()).build();
	private final static Logger logger = LoggerFactory.getLogger(AWSService.class);
	
	 public void createS3Bucket(String bucketName, boolean publicBucket) {
	        if(amazonS3Client.doesBucketExist(bucketName)) {
	            logger.info("Bucket name already in use. Try another name.");
	            return;
	        }
	        if(publicBucket) {
	            amazonS3Client.createBucket(bucketName);
	        } else {
	            amazonS3Client.createBucket(new CreateBucketRequest(bucketName).withCannedAcl(CannedAccessControlList.Private));
	        }
	    }
	 
	  public List<Bucket> listBuckets(){
	        return amazonS3Client.listBuckets();
	    }

	    public void deleteBucket(String bucketName){
	        try {
	            amazonS3Client.deleteBucket(bucketName);
	        } catch (AmazonServiceException e) {
	        	logger.error(e.getErrorMessage());
	            return;
	        }
	    }
	    
	    public void putObject(String bucketName, BucketObjectRepresentaion representation, boolean publicObject) throws IOException {

	        String objectName = representation.getObjectName();
	        String objectValue = representation.getText();

	        File file = new File("." + File.separator + objectName);
	        FileWriter fileWriter = new FileWriter(file, false);
	        PrintWriter printWriter = new PrintWriter(fileWriter);
	        printWriter.println(objectValue);
	        printWriter.flush();
	        printWriter.close();

	        try {
	            if(publicObject) {
	                var putObjectRequest = new PutObjectRequest(bucketName, objectName, file).withCannedAcl(CannedAccessControlList.PublicRead);
	                amazonS3Client.putObject(putObjectRequest);
	            } else {
	                var putObjectRequest = new PutObjectRequest(bucketName, objectName, file).withCannedAcl(CannedAccessControlList.Private);
	                amazonS3Client.putObject(putObjectRequest);
	            }
	        } catch (Exception e){
	        	logger.error("Some error has ocurred.");
	        }

	    }
	    
	    public List<S3ObjectSummary> listObjects(String bucketName){
	        ObjectListing objectListing = amazonS3Client.listObjects(bucketName);
	        return objectListing.getObjectSummaries();
	    }

	    public void downloadObject(String bucketName, String objectName){
	        S3Object s3object = amazonS3Client.getObject(bucketName, objectName);
	        S3ObjectInputStream inputStream = s3object.getObjectContent();
	        try {
	            FileUtils.copyInputStreamToFile(inputStream, new File("." + File.separator + objectName));
	        } catch (IOException e) {
	        	logger.error(e.getMessage());
	        }
	    }
	    
	    public void deleteObject(String bucketName, String objectName){
	        amazonS3Client.deleteObject(bucketName, objectName);
	    }

	    public void deleteMultipleObjects(String bucketName, List<String> objects){
	        DeleteObjectsRequest delObjectsRequests = new DeleteObjectsRequest(bucketName)
	                .withKeys(objects.toArray(new String[0]));
	        amazonS3Client.deleteObjects(delObjectsRequests);
	    }

	    public void moveObject(String bucketSourceName, String objectName, String bucketTargetName){
	        amazonS3Client.copyObject(
	                bucketSourceName,
	                objectName,
	                bucketTargetName,
	                objectName
	        );
	    }**/

}
