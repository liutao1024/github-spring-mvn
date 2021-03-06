package cn.spring.mvn.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LiuTao @date 2018年9月3日 下午3:25:42
 * @ClassName: SocketThread 
 * @Description: TODO(socket 线程类)
 */
public class SocketThread extends Thread {
	private ServerSocket serverSocket = null;

	public SocketThread(ServerSocket serverScoket) {
		try {
			if (null == serverSocket) {
				this.serverSocket = new ServerSocket(8088);
				System.out.println("socket start");
			}
		} catch (Exception e) {
			System.out.println("SocketThread创建socket服务出错");
			e.printStackTrace();
		}

	}

	public void run() {
		while (!this.isInterrupted()) {
			try {
				Socket socket = serverSocket.accept();

				if (null != socket && !socket.isClosed()) {
					// 处理接受的数据
					new SocketOperator(socket).start();
				}
				socket.setSoTimeout(30000);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void closeSocketServer() {
		try {
			if (null != serverSocket && !serverSocket.isClosed()) {
				serverSocket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
