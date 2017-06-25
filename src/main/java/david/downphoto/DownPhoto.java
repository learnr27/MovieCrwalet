package david.downphoto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DownPhoto {
	private List<String> list = new ArrayList<String>();

	public DownPhoto() throws Exception {
		readFile();
	}

	private void readFile() throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("分析.txt"));
		while (bufferedReader.ready()) {
			String line = bufferedReader.readLine();
			line = line.split("照片:")[1];
			list.add(line);
		}
		bufferedReader.close();
		down();
	}

	private void down() {
		File file = null;
		URL u = null;
		for (int i = 0; i < list.size(); i++) {
			file = new File("D:\\2\\" + (i + 1) + ".jpg");
			if (file.exists())
				continue;
			InputStream inputStream = null;
			try {
				if (!list.get(i).equals("http://image11.m1905.cn/uploadfile/1/nopic.jpg")) {
					u = new URL(list.get(i));
					inputStream = u.openConnection().getInputStream();
				} else {
					inputStream = new FileInputStream("D:\\2\\91.jpg");
				}
				byte[] bs = new byte[1024*10];
				int j = 0;
				OutputStream outputStream = new FileOutputStream(file);
				while ((j = inputStream.read(bs)) > 0)
					outputStream.write(bs, 0, j);
				outputStream.flush();
				outputStream.close();
				inputStream.close();
				System.out.println("下载完成"+file.getName());
			} catch (Exception e) {
				continue;
			}
		}
	}

	public static void main(String[] args) {
		try {
			new DownPhoto();
		} catch (Exception e) {
		}
	}
}
