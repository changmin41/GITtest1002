package edu.sm;

import edu.sm.dao.TotalOrderDao;
import edu.sm.dto.*;
import edu.sm.service.CouponService;
import edu.sm.service.CustService;
import edu.sm.service.ItemService;
import edu.sm.service.TotalOrderService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CustService custService = new CustService();
        CouponService couponService = new CouponService();
        ItemService itemService = new ItemService();


        Scanner sc = new Scanner(System.in);
        boolean lobby = true;
        boolean login = false;

        while (lobby) {
            System.out.println("-------------쇼핑몰-------------");
            System.out.println("1.[회원가입] 2.[로그인] 3.[종료] : ");
            int num = sc.nextInt();

            if (num == 1) {
                System.out.println("[회원가입]");
                System.out.println("사용하실 아이디를 입력하세요");
                String id = sc.next();
                System.out.println("사용하실 비밀번호를 입력하세요");
                String pwd = sc.next();
                System.out.println("이름을 입력하세요");
                String name = sc.next();
                System.out.println("나이를 입력하세요");
                Integer age = Integer.valueOf(sc.next());
                System.out.println("성별을 입력하세요 (m/w)");
                String genderInput = sc.next();
                Character gen = genderInput.charAt(0);
                System.out.println("전화번호를 입력하세요");
                String number = sc.next();
                System.out.println("주소를 입력하세요");
                String add = sc.next();
                System.out.println("메일을 입력하세요");
                String mail = sc.next();

                Cust cust = Cust.builder()
                        .cust_id(id).cust_pwd(pwd).cust_name(name)
                        .cust_age(age).gender(gen).cust_num(number)
                        .cust_add(add).cust_mail(mail).build();
                try {
                    custService.C91_1(cust);
                    System.out.println("회원가입 성공 !");
                } catch (Exception e) {
                    System.out.println("회원가입 실패: " + e.getMessage());
                }
            } else if (num == 2) {
                System.out.println("-------[로그인]-------");
                System.out.println("아이디: ");
                String logined_id = sc.next();
                System.out.println("비밀번호: ");
                String pwd = sc.next();
                Cust cust = null;
                try {
                    cust = custService.loginCheck(logined_id, pwd);
                    if (cust != null) {
                        System.out.println("로그인 성공! 환영합니다, " + cust.getCust_name() + "님!");
                        login = true;
                    } else {
                        System.out.println("로그인 실패! 아이디 또는 비밀번호를 확인하세요.");
                    }
                } catch (Exception e) {
                    System.out.println("시스템 오류로 로그인을 처리할 수 없습니다.");
                    e.printStackTrace();
                }


                while (login) {
                    System.out.println("1.[상품목록] 2.[마이페이지] 3.[로그아웃]");
                    int userChoice = sc.nextInt();

                    if (userChoice == 1) {
                        List<Item> items;
                        try {
                            items = itemService.C31_1();
                            for (Item item : items) {
                                System.out.println( "id :" + item.getItem_id() +" 상품명: "+ item.getItem_name() +" 가격: " + item.getItemPrice());
                            }
                            System.out.println("상품을 선택해주세요: ");
                            int selected_item_id = sc.nextInt();
                            Item selectedItem = itemService.C311_1(selected_item_id);
                            System.out.println(selectedItem);
                            System.out.println("1.[장바구니 담기] 2.[주문하기]");
                            int dsakfljlk = sc.nextInt();
                            switch (dsakfljlk) {
                                case 1:
                                    System.out.println("개수 선택");
                                    int item_num = sc.nextInt();

                                case 2:
                                    System.out.println("개수 선택:");
                                    int item_num2 = sc.nextInt();

                                    System.out.println("수령인 이름을 입력하세요: ");
                                    String receiver = sc.next();

                                    System.out.println("수령인 전화번호를 입력하세요: ");
                                    String receiver_num = sc.next();

                                    System.out.println("배송지 주소를 입력하세요: ");
                                    String receiver_add = sc.next();

                                    System.out.println("배송지 상세 주소를 입력하세요: ");
                                    String receiver_add_detail = sc.next();

                                    System.out.println("요청 사항을 입력하세요: ");
                                    String request = sc.next();

                                    System.out.println("결제 방법을 선택하세요 (예: 카드, 현금): ");
                                    String payment_method = sc.next();

                                    int pay_price = selectedItem.getItemPrice() * item_num2;

                                    try {
                                        TotalOrder totalOrder = new TotalOrder();
                                        totalOrder.setCust_id(cust.getCust_id());
                                        totalOrder.setCupon_id(null);
                                        totalOrder.setOrder_date(new java.sql.Date(System.currentTimeMillis()));
                                        totalOrder.setPayment_method(payment_method);
                                        totalOrder.setPay_price(pay_price);
                                        totalOrder.setReciver(receiver);
                                        totalOrder.setReciver_num(receiver_num);
                                        totalOrder.setReciver_add(receiver_add);
                                        totalOrder.setReciver_add_detail(receiver_add_detail);
                                        totalOrder.setRequest(request);

                                        TotalOrderDao totalOrderDao = new TotalOrderDao();
                                        System.out.println("주문이 완료되었습니다! 주문번호: " + totalOrder.getOrder_id());

                                    } catch (Exception e) {
                                        System.out.println("주문 처리 중 오류가 발생했습니다: " + e.getMessage());
                                        e.printStackTrace();
                                    }
                                    break;
                            }

                        } catch (Exception e) {
                            System.out.println("상품 목록을 불러오는 중 오류가 발생했습니다: " + e.getMessage());
                        }
                    } else if (userChoice == 2) {
                        System.out.println("1.[회원정보 조회] 2.[구매목록] 3.[쿠폰목록]");
                        int myPage = sc.nextInt();

                        if (myPage == 1) {
                            System.out.println("회원정보 조회 페이지입니다.");
                            try{
                                cust = custService.C4_1(cust.getCust_id());
                                System.out.println(cust);
                            }catch(Exception e){
                                throw new RuntimeException(e);
                            }
                        } else if (myPage == 2) {
                            TotalOrderService totalOrderService = new TotalOrderService();
                            List<TotalOrder> totalOrders;

                            try {
                                totalOrders = totalOrderService.C43_1(logined_id);
                                for (TotalOrder totalOrder : totalOrders) {
                                    System.out.println("주문번호:" + totalOrder.getOrder_id() +
                                            " 주문날짜:" + totalOrder.getOrder_date() +
                                            " 가격:" + totalOrder.getPay_price());
                                }
                            } catch (Exception e) {
                                System.out.println("구매 목록을 불러오는 중 오류가 발생했습니다: " + e.getMessage());
                            }
                        } else if (myPage == 3) {

                            System.out.println("쿠폰 목록 조회 페이지입니다.");
                            List<CouponBox> couponBoxes = null;
                            try{
                                couponBoxes = couponService.C44_1(cust.getCust_id());
                                for(CouponBox couponBox : couponBoxes){
                                    System.out.println(couponBox);
                                }
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }

                        } else {
                            System.out.println("잘못된 선택입니다.");
                        }
                    } else if (userChoice == 3) {
                        login = false;
                        System.out.println("로그아웃 되었습니다.");
                    } else {
                        System.out.println("올바른 선택이 아닙니다.");
                    }
                }
            } else if (num == 3) {
                // 종료
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            } else {
                System.out.println("올바른 번호를 입력하세요..!");
            }
        }
    }
}
