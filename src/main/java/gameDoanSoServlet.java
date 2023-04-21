import model.NguoiChoi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "gameDoanSoServlet", urlPatterns = {"/doanso"})
public class gameDoanSoServlet extends HttpServlet {
    int randomNum = (int) Math.round( Math.random() * 1000);
    List<NguoiChoi> list = new ArrayList<>();
    int soLanDoan = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("gamedoanso.jsp").forward(req,resp);
        System.out.println(randomNum);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String tenNguoiChoi = req.getParameter("tenNguoiChoi");
        String strSoDoan = req.getParameter("soDoan");
        int soDoan = 0;
        if (!strSoDoan.isEmpty()) {
            soDoan = Integer.parseInt(strSoDoan);
        }
        String message = "";

        NguoiChoi nguoiChoi = new NguoiChoi();


        if (soDoan < randomNum) {
            soLanDoan++;
            message="Số của bạn nhỏ hơn của tôi";
        }
        else if (soDoan > randomNum) {
            soLanDoan++;
            message="Số của bạn lớn hơn của tôi";

        }
        else {

            soLanDoan++;
            message="Chúc mừng " + tenNguoiChoi + " đã đoán chính xác.";
            nguoiChoi.setTenNguoiChoi(tenNguoiChoi);
            nguoiChoi.setSoLanDoan(soLanDoan);
            nguoiChoi.setSoDoan(soDoan);
            list.add(nguoiChoi);
            soLanDoan = 0;
        }

        req.setAttribute("list", list);
        req.setAttribute("message",message);

        req.getRequestDispatcher("gamedoanso.jsp").forward(req,resp);

    }
}
