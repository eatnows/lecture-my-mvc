package org.example.web_calculator;

import org.example.calculator.Calculator;
import org.example.calculator.calculate.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomWebApplicationServer {
    private final int port;
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebApplicationServer] started {} port.", port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected.");

                /**
                 * Step2 - 사용자 요청이 들어올 때마다 Thread 를 새로 생성해서 사용자 요청을 처리하도록 한다.
                 */
                // Thread 를 새로 생성하면 독립적인 스택 메모리를 새로 할당받는다.
                // Thread 가 많아지면 CPU 컨텍스트 스위칭이 많아진다.
                // CPU 의 사용량과 메모리의 사용량이 증가된다.
                // ----> 서버 다운
//                new Thread(new ClientRequestHandler(clientSocket)).start();

                /**
                 * Step3 - Thread Pool 을 적용해 안정적인 서비스가 가능하도록 한다.
                 */
                // Thread pool 이용
                executorService.execute(new ClientRequestHandler(clientSocket));
            }
        }
    }
}
