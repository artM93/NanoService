import java.util.HashMap;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {

        //инициализация микросервиса для подписки
        NanoService sender = new NanoService();

        //инициализация сервиса-слушателей
        HashMap<String, ServiceOne> services = new HashMap<>();
        for (int i = 0; i < 5000; i++) {
            services.put(String.valueOf(i), new ServiceOne(String.valueOf(i)));
        }

        //инициализация побочного потока для эмуляции  рандомной подписки\отписки сервисов-слушателей
        EmulateSubscribe emulateSubscribe = new EmulateSubscribe();
        emulateSubscribe.setSender(sender);
        emulateSubscribe.setServices(services);
        emulateSubscribe.start();


        /* постоянное информирование подписчиков раз в 1 секунду о новой информации*/
        while (true) {

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            sender.informClients(sender.getInfoFromRes());
        }
    }
}