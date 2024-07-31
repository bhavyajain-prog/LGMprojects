import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CurrencyConverterServlet")
public class CurrencyConverterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fromCurrency = request.getParameter("from");
        String toCurrency = request.getParameter("to");
        double amount = Double.parseDouble(request.getParameter("amount"));
        
        double conversionRate = getConversionRate(fromCurrency, toCurrency);
        double convertedAmount = amount * conversionRate;
        
        response.setContentType("text/plain");
        response.getWriter().write(String.valueOf(convertedAmount));
    }

    private double getConversionRate(String from, String to) {
        if (from.equals("USD") && to.equals("INR")) {
            return 74.50;
        } else if (from.equals("INR") && to.equals("USD")) {
            return 0.013;
        }
        return 1.0;
    }
}
