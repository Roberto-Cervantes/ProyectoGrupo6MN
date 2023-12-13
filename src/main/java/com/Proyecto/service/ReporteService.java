
package com.Proyecto.service;

import java.io.IOException;
import java.util.Map;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author LUIS
 */
public interface ReporteService {
    
    //Se define la firma del metodo que genera los reportes, con los siguiente parametros
    //1. Reporte: es el nombre del archivo de reporte (.jasper)
    //2. parametros: un Map que contiene los parametros del reporte ... si los ocupa
    //3. tipo: es el tipo de reporte: vPdf, Pdf, Xls, Csv
    public ResponseEntity<Resource>  generaReporte(
      String reporte,
            Map<String, Object> parametros,
            String tipo) throws IOException;
    
    
    
}
