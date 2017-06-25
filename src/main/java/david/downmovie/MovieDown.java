package david.downmovie;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * 下载电影网全部电影网页
 * @author 张伟
 * @version 2017-6-15
 */
public class MovieDown extends Thread {
	private String start = "http://www.1905.com/mdb/film/list/o0d0p";
	private int s, end;

	/**
	 * 利用多线程进行下载
	 * @param s 开始下载的网页
	 * @param end 结束下载的最后一个网页
	 */
	public MovieDown(int s, int end) {
		this.s = s;
		this.end = end;
	}

	/**
	 * 重写线程
	 */
	@Override
	public void run() {
		init();
	}

	/**
	 * 先判断D盘下的名字叫1文件夹下有没有文件并且文件的名字是网页的顺序。
	 */
	private void init() {
		CloseableHttpClient client = HttpClients.custom().build();
		HttpUriRequest request = null;
		for (int i = s; i <= end; i++) {
			try {
				File file = new File("D:\\1\\" + i + ".txt");
				if (file.exists() && file.length() > 100000)
					continue;
				else {
					System.out.println(i);
				}
				request = new HttpGet(start + i + ".html");
				HttpResponse response = client.execute(request);
				HttpEntity entity = response.getEntity();
				entity.writeTo(new FileOutputStream(file));
			} catch (Exception e) {
			}
		}
	}

	/**
	 * 网页从001到10848页
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 96; i++)
			new MovieDown(i * 113 + 1, (i + 1) * 113).start();
	}
}
