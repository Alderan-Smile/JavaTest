package cl.smile.javatest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.Getter;

/**
 * @author Oliver Consterla Araya
 * @version 0.1
 * @since 2022
 */
@Component
public class PropiedadesConfig {
    
    @Getter
    private static String fileName;
    @Getter
    private static String fileNameNo;
    @Getter
    private static String fileNameSep;
    @Getter
    private static String fileNameExt;
    @Getter
    private static String filePath;
    @Getter
    private static String delimiterText;
    @Getter
    private static Boolean appendFile;
    @Getter
    private static Boolean borrarVoid;
    @Getter
    private static Boolean borrarExiste;

    @Value("${file.name}")
    public void setFileName(String in){
        fileName = in;
    }
    @Value("${file.name.no}")
    public void setFileNameNo(String in){
        fileNameNo = in;
    }
    @Value("${file.name.separator}")
    public void setFileNameSep(String in){
        fileNameSep = in;
    }
    @Value("${file.name.extension}")
    public void setFileNameExt(String in){
        fileNameExt = in;
    }
    @Value("${file.path}")
    public void setFilePath(String in){
        filePath = in;
    }
    @Value("${delimiter}")
    public void setDelimiterText(String in){
        delimiterText = in;
    }
    @Value("${seguir.escribiendo}")
    public void setAppendFile(Boolean in){
        appendFile = in;
    }
    @Value("${borrar.vacio}")
    public void setBorrarVoid(Boolean in){
        borrarVoid = in;
    }
    @Value("${borrar.existe}")
    public void setBorrarExiste(Boolean in){
        borrarExiste = in;
    }
}
