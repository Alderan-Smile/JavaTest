package cl.smile.javatest.funciones;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;

import cl.smile.javatest.config.PropiedadesConfig;
import cl.smile.javatest.model.FechaEntity;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Oliver Consterla Araya
 * @version 0.1
 * @since 2022
 */
@Slf4j
public class FileEscritor {
    
    public static FlatFileItemWriter<FechaEntity> flatFileItemWriter = new FlatFileItemWriter<>();
    public static DelimitedLineAggregator<FechaEntity> delimitedLineAggregator = new DelimitedLineAggregator<>();
    public static FileSystemResource fileName;
    static List<String> lineaHeader = new ArrayList<>();

    static String header = "Fecha Date"+";"+
                        "Fecha Corta"+";"+
                        "Hora"+";"+
                        "Tramo fijo";
        

    public static BeanWrapperFieldExtractor<FechaEntity> beanWrapperFieldExtractor = new BeanWrapperFieldExtractor<FechaEntity>(){
        @Override
        public Object[] extract(FechaEntity adelTrxDto){
            return new Object[] {
                adelTrxDto.getId().getFechaDate(),
                adelTrxDto.getFechaC(),
                adelTrxDto.getHoraStr(),
                adelTrxDto.getId().getTramoInt()
            };
        }
    };

    /**
     * @param items Recibe una lista de objetos para escribir
     * @param file Recibe el nombre del archivo a escribir
     */
    public static void escribirArchivo(List<FechaEntity> items,String file){

        fileName = new FileSystemResource(PropiedadesConfig.getFilePath()+file+PropiedadesConfig.getFileNameSep()+TimeModifier.dateToString("ddMMyy",new Date())+PropiedadesConfig.getFileNameExt());
        flatFileItemWriter.setResource(fileName);
        log.info("{}",fileName);
        flatFileItemWriter.setAppendAllowed(PropiedadesConfig.getAppendFile());
        flatFileItemWriter.setShouldDeleteIfEmpty(PropiedadesConfig.getBorrarVoid());
        flatFileItemWriter.setShouldDeleteIfExists(PropiedadesConfig.getBorrarExiste());
        delimitedLineAggregator.setDelimiter(PropiedadesConfig.getDelimiterText());

        beanWrapperFieldExtractor.setNames(new String[] {
            "fechaDate",
            "fechaC",
            "horaStr",
            "tramoInt"
        });
        delimitedLineAggregator.setFieldExtractor(beanWrapperFieldExtractor);
        lineaHeader.add(header);

        flatFileItemWriter.setHeaderCallback(new FlatFileHeaderCallback() {
            public void writeHeader(Writer writer) throws IOException {
                for (String header:lineaHeader) {
                    writer.write(header);
                }
            }
        });
        flatFileItemWriter.setLineAggregator(delimitedLineAggregator);
        flatFileItemWriter.open(new ExecutionContext());

        try {
            flatFileItemWriter.write(items);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        flatFileItemWriter.close();
    }
    
}
