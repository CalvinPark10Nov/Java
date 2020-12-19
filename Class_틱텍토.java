package Class;
//틱택토

import java.util.Random;
import java.util.Scanner;

class TickTacToe {
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();

	String[][] game = new String[3][3];

	int turn = 0;
	int win = 0;
	String name = "";

	// game 배열을 공백(" ")으로 초기화

	void setGame() {
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game[i].length; j++) {
				game[i][j] = " ";
			}
		}
	}

	void showGame() {
		System.out.println("===" + name + "====");
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game[i].length; j++) {
				System.out.print("[" + game[i][j] + " ]");
			}
			System.out.println();
		}
		System.out.println("==================");
	}

	void choiceIdx() {
		if (turn % 2 == 0) {
			System.out.println("[1턴] ");
			int xidx = scan.nextInt();
			int yidx = scan.nextInt();

			if (game[xidx][yidx].equals(" ")) {
				game[xidx][yidx] = " O ";
				turn += 1;
			} else {
				System.out.println("잘못입력했습니다. ");
			}
		} else if (turn % 2 == 1) {
			System.out.println("[2턴]");
			int xidx = scan.nextInt();
			int yidx = scan.nextInt();

			if (game[xidx][yidx].equals(" ")) {
				game[xidx][yidx] = " X ";
				turn += 1;
			} else {
				System.out.println("잘못입력했습니다. ");
			}
		}
	}

	// 가로 검사
	// 00 01 02
	// 10 11 12
	// 20 21 22
	void exitWidth() {
		for (int i = 0; i < game.length; i++) {
			if (game[i][0].equals(" O ") && game[i][1].equals(" O ") && game[i][2].equals(" O ")) {
				win = 1;
				System.out.println("1플레이어 승리. ");
			} else if (game[i][0].equals(" X ") && game[i][2].equals(" X ") && game[i][2].equals(" X ")) {
				win = 2;
				System.out.println("2플레이어 승리");
			}
		}
	}

	// 세로검사
	// 00 10 20
	// 01 11 21
	// 02 12 22
	void exitheight() {
		for (int i = 0; i < game.length; i++) {
			if (game[0][i].equals(" O ") && game[1][i].equals(" O ") && game[2][i].equals(" O ")) {
				win = 1;
				System.out.println("1플레이어 승리! ");
			} else if (game[0][i].equals(" X ") && game[1][i].equals(" X ") && game[2][i].equals(" X ")) {
				win = 2;
				System.out.println("2플레이어 승리!");
			}
		}
	}

	// 대각선 검사
	// 00 11 22
	// 02 11 20
	void exitCross() {
		if (game[0][0].equals(" O ") && game[1][1].equals(" O ") && game[2][2].equals(" O ")) {
			win = 1;
			System.out.println("1플레이어 승리!");
		}
		else if(game[0][0].equals(" X ") && game[1][1].equals(" X ") && game[2][2].equals(" X ")) {
			win =2;
			System.out.println("2플레이어 승리!");
		}
	}
	void run () {
		//game 배열을 공백 문자열 ( " " )로 초기화.
		setGame();
		
		while(true) {
			showGame();
			
			//게임종료
			if(win == 1) {
				System.out.println("1플레이어승리!");
				break;
			}else if(win == 2) {
				System.out.println("2플레이어 승리!");
				break;
			}
			choiceIdx();
			exitWidth();
			exitheight();
			exitCross();
		}
	}
}

public class Class_틱텍토 {
	public static void main(String[] args) {
	TickTacToe game = new TickTacToe();
	game.run();
	}
}
