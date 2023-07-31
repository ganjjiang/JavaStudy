class ThreadTest06 implements Runnable {

	static boolean autoSave = false; 
	
	public static void main(String[] args) {
		
		Thread t = new Thread(new ThreadTest06()); //Thread(Runnable r) 생성자를 호출할때는 Runnable 인터페이스를 전달하여 
		
		t.setDaemon(true); // 이 부분이 없으면 종료되지 않는다. true = daemonThread 
		//없으면 일반 쓰레드가 됨으로 main이 종료되도 종료되지않는다. 
		t.start();
		
		
		for(int i=1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {}
			System.out.println(i);
			
			//5초대에 autoSave가 트루 => 자동저장 메시지 실행 
			if(i==5) autoSave = true;
		}
		System.out.println("프로그램을 종료합니다");

	}
	
	public void run() {
		while(true) { //무한루프지만 main쓰레드가 종료됨에 따라 무한루프도 끝남 
			try {
				Thread.sleep(3*1000);
			} catch(InterruptedException e) {}
			
			if(autoSave) autoSave();
		}
	}
	
	public void autoSave() {
		System.out.println("작업파일이 자동저장되었습니다.");
	}

}
