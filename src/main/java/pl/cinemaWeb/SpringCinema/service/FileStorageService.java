package pl.cinemaWeb.SpringCinema.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.cinemaWeb.SpringCinema.exception.FileStorageException;
import pl.cinemaWeb.SpringCinema.property.FileStorageProperties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Nie można utworzyć katalogu na pliki", ex);
        }
    }

    public String storeFile(MultipartFile file, String fileName){
        // Normalize file name
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Błąd! Plik zawiera niedozwolone znaki!" + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Błąd zapisu " + fileName + ". Spróbuj ponownie", ex);
        }
    }

    public String fileNameNormalize(String fileName){
        fileName = fileName.replaceAll("\\s", "-");
        fileName = fileName.replace("/", "");
        fileName = fileName.replace(":", "");
        fileName = fileName.replace("?", "");
        fileName = fileName.replace("\\", "");
        fileName = fileName.replace("*", "");
        fileName = fileName.replaceAll("\"", "");
        fileName = fileName.replace("*", "");
        fileName = fileName.replace("<", "");
        fileName = fileName.replace(">", "");
        fileName = fileName.replace("|", "");
        return fileName;
    }
}
