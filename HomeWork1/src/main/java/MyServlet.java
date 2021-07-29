import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;
// http://localhost:8081/HomeWork1_war/myservlet
@WebServlet("/myservlet")
    public class MyServlet extends HttpServlet {
    private List<String> list;
    private List<Product> listPr;
    private Product product;
    private static int  count;

    @Override
    public void init() throws ServletException {
        list = new ArrayList<>();
        listPr = new ArrayList<>();
        count = 0;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean flag = false;
        int id = 0;
        String title = "";
        double cost = 0;


        resp.getWriter().println("<h3>Форма для добавления</h3>");
        resp.getWriter().println("<form method='post'> \t*            id:" +
                "<form method='post'> \t\t*    Наименование:" +
                "<form method='post'> *  Введите Цену     <br/>");
        resp.getWriter().println("<input type='int' name='id'>" +
                "<input type='text' name='title'>" +
                "<input type='double' name='cost'><br/>");
        resp.getWriter().println("<input type='submit'>");
        resp.getWriter().println("</form>");
        resp.getWriter().println("<p>" +"Введено товаров: "+ count + "</p>");

        if(Flag.isInt(req.getParameter("id"))) {
            id = Integer.parseInt(req.getParameter("id"));
            flag = true;
        }
        if( (req.getParameter("title") != null) && flag){
            title = req.getParameter("title");

        } else flag = false;

        if((Flag.isDouble(req.getParameter("cost"))) && flag) {
            cost = Double.parseDouble(req.getParameter("cost"));
            product = new Product(id, title, cost);
            listPr.add(product);
            count++;
        }

        if (count==10) {
            int i = 1;
            for (Product s : listPr) {
                    resp.getWriter().println("<p>" + "Product №"+ i + ": " + s + "</p>");
                    i++;
            }
            count = 0;
            i = 0;
            listPr.clear();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}