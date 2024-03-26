package thiGK.ntu63133716.TranThaiNgocdo_63133716.models;

public class DTOQuanNuoc {

	    private String maDoUong;
	    private String tenDoUong;
	    private int soLuong;
	    private double donGia;

	    public DTOQuanNuoc(String maDoUong, String tenDoUong, int soLuong, double donGia) {
	        this.maDoUong = maDoUong;
	        this.tenDoUong = tenDoUong;
	        this.soLuong = soLuong;
	        this.donGia = donGia;
	    }
	    public DTOQuanNuoc() {
	    	super();
	    }

	    // Getters and setters
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
