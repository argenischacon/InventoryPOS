
package reports;

import datos.BaseDatos;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class ReportGenerator {
    
    public void generarReporte(LocalDate fechaInicial, LocalDate fechaFinal){
        try (Connection conn = BaseDatos.getConnection()) {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource("/reports/ventas.jasper"));
            
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("FECHA_INICIAL", Date.valueOf(fechaInicial));
            parameters.put("FECHA_FINAL", Date.valueOf(fechaFinal));
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
}
