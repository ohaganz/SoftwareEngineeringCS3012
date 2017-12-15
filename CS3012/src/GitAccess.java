import java.text.MessageFormat;
import java.util.Scanner;
import java.io.*;

import org.eclipse.egit.github.core.CommitStats;
import org.eclipse.egit.github.core.IRepositoryIdProvider;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryCommit;
import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.repos;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.client.PageIterator;
import org.eclipse.egit.github.core.service.CommitService;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.egit.github.core.service.UserService;



public class GitAccess {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter your username:");
		Scanner input = new Scanner (System.in);
		String username = input.next();	
		input.close();
		User user = getUser(username);
		System.out.println("Information on this user:\nLogin: "
							+ user.getLogin() + "\nName: "
							+ user.getName() + "\nEmail: "
							+ user.getEmail() + "\nFollowers: "
							+ user.getFollowers() + "\nFollowing: "
							+ user.getFollowing() + "\nPublic Repos: "
							+ user.getPublicRepos() + "\nPrivate Repos: "
							+ user.getTotalPrivateRepos());
			
		String getName = user.getName();		String email = user.getEmail();
		String url = user.getUrl();
		int followers = user.getFollowers();
		int following = user.getFollowing();
		int publicRepos = user.getPublicRepos();
		int privateRepos = user.getTotalPrivateRepos();

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(0.06,0.09, 0.90, 0.09);
		StdDraw.line(0.06,0.09, 0.06, 0.92);
		
		double x = 0.002;
		
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.filledRectangle(0.17, 0.1+(x * followers), 0.1, x * followers);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledRectangle(0.38, 0.1+(x*following), 0.1, x * following);
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.filledRectangle(0.59, 0.1+(x*publicRepos), 0.1, x * publicRepos);
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.filledRectangle(0.80, 0.1+(x*privateRepos), 0.1, x * privateRepos);
		
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setNumberFont();
		StdDraw.text(0.035,0.1,"0");
		StdDraw.text(0.035,0.2,"25");
		StdDraw.text(0.035,0.3,"50");
		StdDraw.text(0.035,0.4,"75");
		StdDraw.text(0.035,0.5,"100");
		StdDraw.text(0.035,0.6,"125");
		StdDraw.text(0.035,0.7,"150");
		StdDraw.text(0.035,0.8,"175");
		StdDraw.text(0.035,0.9,"200");
		
		StdDraw.setFont();
		StdDraw.text(0.16,0.05,"Followers (" +followers + ")" );
		StdDraw.text(0.38,0.05,"Following (" +following + ")");
		StdDraw.text(0.59,0.05,"Public Repos (" +publicRepos + ")");
		StdDraw.text(0.81,0.05,"Private Repos (" +privateRepos + ")");;
		StdDraw.text(0.1,1, "Username - " + username);
		StdDraw.text(0.45,1, "Name - " + getName);
		StdDraw.text(0.85,1, "Email - " + email);
		
	
	}
	
	
	
	private static User getUser(String login) throws IOException{
		UserService user = new UserService();
		return user.getUser(login);
		
	}
		
}