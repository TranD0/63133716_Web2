package thiGK.ntu63133716.TranThaiNgocDo_63133716.models;

public class DTDoUong {
    private String maDoUong;
    private String tenDoUong;
    private int soLuong;
    private double donGia;

    public DTDoUong(String maDoUong, String tenDoUong, int soLuong, double donGia) {
        this.maDoUong = maDoUong;
        this.tenDoUong = tenDoUong;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
    public  DTDoUong() {
		super();
	}
    public String getMaDoUong() {
        return maDoUong;
    }

    public void setMaDoUong(String maDoUong) {
        this.maDoUong = maDoUong;
    }

    public String getTenDoUong() {
        return tenDoUong;
    }

    public void setTenDoUong(String tenDoUong) {
        this.tenDoUong = tenDoUong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
}
