import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
public class ZipCompressionStrategy implements CompressionStrategy {
    @Override
    public void compressFile(String inputFile, String outputFile) {
        try {
            FileInputStream fileToCompress = new FileInputStream(inputFile);
            FileOutputStream compressedFile = new FileOutputStream(outputFile);
            ZipOutputStream zipOutputStream = new ZipOutputStream(compressedFile);

            ZipEntry entry = new ZipEntry(new File(inputFile).getName());
            zipOutputStream.putNextEntry(entry);

            byte[] data = new byte[1024];
            int readBytes;
            while ((readBytes = fileToCompress.read(data)) >= 0) {
                zipOutputStream.write(data, 0, readBytes);
            }

            zipOutputStream.closeEntry();
            fileToCompress.close();
            zipOutputStream.close();
            compressedFile.close();

            System.out.println("File compressed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void decompressFile(String inputFile, String outputFile) {
        try {
            FileInputStream fileToDecompress = new FileInputStream(inputFile);
            ZipInputStream zipInputStream = new ZipInputStream(fileToDecompress);

            FileOutputStream decompressedFile = new FileOutputStream(outputFile);
            ZipEntry entry = zipInputStream.getNextEntry();

            byte[] data = new byte[1024];
            int readBytes;
            while ((readBytes = zipInputStream.read(data)) >= 0) {
                decompressedFile.write(data, 0, readBytes);
            }

            zipInputStream.closeEntry();
            zipInputStream.close();
            decompressedFile.close();
            fileToDecompress.close();

            System.out.println("File decompressed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
