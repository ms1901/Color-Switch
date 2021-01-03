package application;

import javafx.scene.image.ImageView;

public class LoaderMenuItems {

	private String msg;
	private ImageView imgeholder;
	private DataTable dt;

	LoaderMenuItems(ImageView img, int g, int s, DataTable table) {
		this.setImgeholder(img);
		this.setMsg(new String("Game No: " + g + " Stars Earned: " + s));
		this.setDt(table);

	}

	public ImageView getImgeholder() {
		return imgeholder;
	}

	public void setImgeholder(ImageView imgeholder) {
		this.imgeholder = imgeholder;
	}

	public DataTable getDt() {
		return dt;
	}

	public void setDt(DataTable dt) {
		this.dt = dt;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
