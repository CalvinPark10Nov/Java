package ClassArr02;

import java.util.Scanner;

public class ClassArr_StudentEdit {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student[] list = new Student[1000000];
		int cnt = 0;
		while (true) {
			for (int i = 0; i < cnt; i++) {
				System.out.print("[" + (i + 1) + "]" + list[i].name);
				if (list[i].subjects != null) {
					for (int j = 0; j < list[i].subjects.length; j++) {
						System.out.print(" \t[" + (i + 1) + "]" +list[i].subjects[j].name + " Course : "
								+ list[i].subjects[j].score + " Points.");
					}
				}
				System.out.println();
			}
			System.out.println("======Welcom======");
			System.out.println("[1] Add Students: ");
			System.out.println("[2] Add Classes");
			System.out.println("[3] Add Scores");
			System.out.println("==================");

			int choice = scan.nextInt();
			while (true) {

				if (choice == 1) {
					if (cnt == list.length) {
						System.out.println("You Cannot Edit Anymore. ");
						break;
					} else {
						System.out.println("Input Student Name : ");
						String name = scan.next();

						list[cnt] = new Student();
						list[cnt].name = name;
						cnt += 1;
						break;
					}
				} else if (choice == 2) {
					for (int i = 0; i < cnt; i++) {
						System.out.println("[" + (i + 1) + "]" + list[i].name);
					}
					System.out.println("Select a Student : ");
					int select = scan.nextInt() - 1;
					System.out.println("Input Class to Add : ");
					String course = scan.next();

					if (list[select].subjects == null) {
						list[select].subjects = new Subject[1];
						list[select].subjects[0] = new Subject();
						list[select].subjects[0].name = course;
						break;
					} else {
						int size = list[select].subjects.length;
						Subject[] temp = list[select].subjects;
						
						list[select].subjects = new Subject[size + 1];
						for (int i = 0; i < size; i++) {
							list[select].subjects[i] = temp[i];
						}
						list[select].subjects[size] = new Subject();
						list[select].subjects[size].name = course;
						temp = null;
						break;
					}

				} else if (choice == 3) {
					for (int i = 0; i < cnt; i++) {
						System.out.print("[" + (i + 1) + "]" + list[i].name);
					}
					System.out.println("Select a Student");
					int sel = scan.nextInt() - 1;
					for (int i = 0; i < list[sel].subjects.length; i++) {
						System.out.println("[" + (i + 1) + "]" + list[sel].subjects[i].name);
					}
					System.out.println("Now Select a Course to Edit Score: ");
					int course = scan.nextInt() - 1;

					System.out.println("Input Score : ");
					int score = scan.nextInt();

					list[sel].subjects[course].score = score;

					System.out.println("Thank You for Using!");
					System.out.println("to go back press " + "4");
					int num = scan.nextInt();
					if (num != 4) {
						System.out.println("Error");
						continue;
					} else {
						break;
					}
				}
			}
		}
	}
}