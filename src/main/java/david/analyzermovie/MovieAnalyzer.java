package david.analyzermovie;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import david.story.MovieBean;

/**
 * 分析爬下来的数据类
 * 
 * @author 张伟
 *
 */
public class MovieAnalyzer {

	/**
	 * 文件的绝对路径
	 */
	private final String FileDir = "D:\\1";

	/**
	 * 电影的前缀
	 */
	private final String MovieHead = "http://www.1905.com";

	/**
	 * 保存电影属性的值
	 */
	private List<MovieBean> list = new ArrayList<MovieBean>();

	public MovieAnalyzer() {
		readFile();
	}

	/**
	 * 读取文件夹下的所有文件
	 */
	private void readFile() {
		File fileDir = new File(FileDir);
		if (fileDir.exists() && fileDir.isDirectory()) {
			File file[] = fileDir.listFiles();
			for (File f : file)
				analyzer(f);
		}
	}

	/**
	 * 把每个文件对象进行分析
	 * 
	 * @param file
	 *            文件对象
	 */
	private void analyzer(File file) {
		try {
			Document document = Jsoup.parse(file, "UTF-8");
			Elements elements = document.select(".inqList");
			for (Element element : elements) {
				Elements ee = element.select("li");
				for (Element elemen : ee) {
					String photo=elemen.select("img").get(0).attr("src");
					Elements e = elemen.select("p");
					String movieRUL = MovieHead + e.get(0).select("a").get(0).attr("href");
					String movieName = e.get(0).text();
					String score = e.get(1).text();
					String toStar = e.get(2).text();
					String plot = e.get(3).text();
					MovieBean bean = new MovieBean(movieRUL, movieName, score, toStar, plot,photo);
					list.add(bean);
				}
				System.out.println(file.getName() + "success!");
			}
		} catch (IOException e) {
		}
	}
	/**
	 * 得到所有电影的数据
	 * 
	 * @return
	 */
	public List<MovieBean> getList() {
		return list;
	}
	
	public void write() throws Exception{
		BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("分析.txt"));
		for (MovieBean movieBean : list) {
			bufferedWriter.write(movieBean.toString());
		}
		bufferedWriter.flush();
		bufferedWriter.close();
	}
}
