import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FakeMultiPartFile implements MultipartFile {

    File file;
    String fileName;

    public FakeMultiPartFile(String file, String alternativeName) {
        this.file = new File(file);
        assert this.file.isFile();
        this.fileName = alternativeName;
    }


    @Override
    public String getName() {
        return fileName;
    }

    @Override
    public String getOriginalFilename() {
        return fileName;
    }

    @SneakyThrows
    @Override
    public String getContentType() {
        Path path = new File("product.png").toPath();
        String mimeType = Files.probeContentType(path);
        return mimeType;
    }

    @SneakyThrows
    @Override
    public boolean isEmpty() {
        return getBytes().length == 0;
    }

    @Override
    public long getSize() {
        return file.getTotalSpace();
    }

    @Override
    public byte[] getBytes() throws IOException {
        return Files.readAllBytes(file.toPath());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return Files.newInputStream(file.toPath());
    }

    @Override
    public void transferTo(File file) throws IOException, IllegalStateException {
        throw new IOException("not working");
    }
}
