package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<WiseSaying> wiseSayings = new ArrayList<>();

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine();

            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();

                WiseSaying newSaying = new WiseSaying(content, author);
                wiseSayings.add(newSaying);
                System.out.println(newSaying.id + "번 명언이 등록되었습니다.");
            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언\n----------------------");
                for (int i = wiseSayings.size() - 1; i >= 0; i--) {
                    WiseSaying ws = wiseSayings.get(i);
                    System.out.println(ws.id + " / " + ws.author + " / " + ws.content);
                }
            } else if (command.startsWith("삭제?id=")) {
                int id = Integer.parseInt(command.substring(6));
                boolean found = false;

                for (int i = 0; i < wiseSayings.size(); i++) {
                    WiseSaying ws = wiseSayings.get(i);
                    if (ws.id == id) {
                        wiseSayings.remove(i);
                        System.out.println(id + "번 명언이 삭제되었습니다.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                }
            } else if (command.startsWith("수정?id=")) {
                int id = Integer.parseInt(command.substring(6));
                boolean found = false;

                for (int i = 0; i < wiseSayings.size(); i++) {
                    WiseSaying ws = wiseSayings.get(i);
                    if (ws.id == id) {
                        System.out.println("명언(기존) : " + wiseSayings.get(i).content);
                        System.out.print("명언 : ");
                        String newContent = sc.nextLine();

                        System.out.println("작가(기존) : " + wiseSayings.get(i).author);
                        System.out.print("작가 : ");
                        String newAuthor = sc.nextLine();

                        ws.content = newContent;
                        ws.author = newAuthor;
                        found = true;

                        break;
                    }
                }
                if (!found) {
                    System.out.println(id + "번 명언은 존재하지 않습니다");
                }
            }
        }
    }
}