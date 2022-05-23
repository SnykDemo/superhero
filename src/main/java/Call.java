import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Call {

    public static void main(String[] args) throws IOException {

        MultipartFile file = new FakeMultiPartFile("spdx.json", "../../../../whatever.txt");
        System.out.println(file.getBytes());
    }
}
