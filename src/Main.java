import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("== 명언 앱 실행==");
		int lastId = 0;
		List<WiseSaying> wisesayings = new ArrayList<>();

		while (true) {
			System.out.print("명령어 ) ");
			String cmd = sc.nextLine();

			if (cmd.equals("등록")) {
				int id = lastId + 1;
				System.out.print("명언 : ");
				String title = sc.nextLine();
				System.out.print("작가 : ");
				String body = sc.nextLine();

				System.out.printf("%d번 명언이 등록되었습니다.\n", id);
				lastId++;
				WiseSaying wisesaying = new WiseSaying(id, title, body);
				wisesayings.add(wisesaying);

			} else if (cmd.equals("목록")) {
				if (wisesayings.size() == 0) {
					System.out.println("번호  /  작가  /  명언");
					System.out.println("====================");
					continue;
				} else {
					System.out.println("번호  /  작가  /  명언");
					System.out.println("====================");
					for (int i = wisesayings.size() - 1; i >= 0; i--) {
						System.out.printf("%d  /  %s  /  %s\n", wisesayings.get(i).getId(),
								wisesayings.get(i).getTitle(), wisesayings.get(i).getBody());
					}
				}

			} else if (cmd.startsWith("수정")) {
				String[] cmdBits = cmd.split("\\?");
				String key = cmdBits[1].split("=")[0];
				String value = cmdBits[1].split("=")[1];
				Map<String, String> map = new HashMap<>();
				map.put(key, value);
				for (int i = 0; i < wisesayings.size(); i++) {
					if (wisesayings.get(i).getId() == Integer.parseInt(value)) {
						int id = i + 1;
						System.out.printf("명언(기존) : %s\n", wisesayings.get(i).getBody());
						System.out.printf("작가(기존) : %s\n", wisesayings.get(i).getTitle());
						System.out.print("명언 : ");
						String body = sc.nextLine();
						System.out.print("작가 : ");
						String title = sc.nextLine();
						WiseSaying wisesaying = new WiseSaying(id, title, body);
						wisesayings.get(i).setId(id);
						wisesayings.get(i).setBody(body);
						wisesayings.get(i).setTitle(title);
						System.out.printf("%d번 명언이 수정되었습니다.\n", id);
						continue;
					}

				}
				System.out.printf("%d번 명언은 존재하지 않습니다.\n", Integer.parseInt(value));
			} else if (cmd.startsWith("삭제")) {
				String[] cmdBits = cmd.split("\\?");
				String key = cmdBits[1].split("=")[0];
				String value = cmdBits[1].split("=")[1];
				Map<String, String> map = new HashMap<>();
				map.put(key, value);
				for (int i = 0; i < wisesayings.size(); i++) {
					if (wisesayings.get(i).getId() == Integer.parseInt(value)) {

						wisesayings.remove(i);
						System.out.printf("%d번 명언이 삭제되었습니다.\n", Integer.parseInt(value));
						continue;
					}

				}
				System.out.printf("%d번 명언은 존재하지 않습니다.\n", Integer.parseInt(value));

			}else if(cmd.startsWith("상세보기")) {
				String[] cmdBits = cmd.split("\\?");
				String key = cmdBits[1].split("=")[0];
				String value = cmdBits[1].split("=")[1];
				Map<String, String> map = new HashMap<>();
				map.put(key, value);
				for (int i = 0; i < wisesayings.size(); i++) {
					if (wisesayings.get(i).getId() == Integer.parseInt(value)) {
						
						
						System.out.printf("번호 : %s\n",wisesayings.get(i).getId());
						System.out.print("날짜 : ");
						System.out.printf("작가 : %s\n",wisesayings.get(i).getTitle());
						System.out.printf("내용 : %s\n",wisesayings.get(i).getBody());
						
					
						
					}

				}
				System.out.printf("%d번 명언은 존재하지 않습니다.\n", Integer.parseInt(value));
			}
			else {
				System.out.println("없는 명령어입니다.");
			}
		}

	}

}
