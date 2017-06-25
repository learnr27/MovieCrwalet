package david.test;

import java.util.List;
import david.analyzermovie.MovieAnalyzer;
import david.story.JPAStory;
import david.story.MovieBean;

public class Test {

	public static void main(String[] args) throws Exception {
		MovieAnalyzer analyzer = new MovieAnalyzer();
		List<MovieBean> list = analyzer.getList();
		new JPAStory().story(list);
	}
}
