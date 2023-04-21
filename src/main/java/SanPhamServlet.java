import model.SanPham;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "sanPhamServlet", urlPatterns = {"/sanpham"})
public class SanPhamServlet extends HttpServlet {
    List<SanPham> listSanPham = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.getRequestDispatcher("quanlysanpham.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenSP = req.getParameter("tenSP");

        String stringSoLuong = req.getParameter("soLuong");
        int soLuong = 0;
        if(!stringSoLuong.isEmpty()) {
            soLuong = Integer.parseInt(stringSoLuong);
        }

        String stringGiaBan = req.getParameter("giaBan");
        double giaBan = 0;
        if(!stringGiaBan.isEmpty()) {
            giaBan = Integer.parseInt(stringGiaBan);
        }

        SanPham sanPham = new SanPham();
        sanPham.setTenSP(tenSP);
        sanPham.setSoLuong(soLuong);
        sanPham.setGiaBan(giaBan);

        listSanPham.add(sanPham);
        req.setAttribute("listSanPham", listSanPham);
        req.getRequestDispatcher("quanlysanpham.jsp").forward(req,resp);
    }
}
