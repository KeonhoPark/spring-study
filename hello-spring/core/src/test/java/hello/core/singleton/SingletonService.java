package hello.core.singleton;

public class SingletonService {

    private static SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    //생성자를 private으로 선언하여 다른곳에서 객체 생성 막음
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
