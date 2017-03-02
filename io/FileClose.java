package io;

import java.io.Closeable;
import java.io.IOException;

public class FileClose {

	public static void Closing(Closeable...args){
		for(Closeable file:args){
			if(file!=null){
				try {
					file.close();
				} catch (IOException e) {
					System.out.println("文件关闭失败");
				}
			}
		}
	}
	@SuppressWarnings("unchecked")
	public static<T extends Closeable> void FileCosing(T...args){
		for(T t:args){
			if(t!=null){
				try {
					t.close();
				} catch (IOException e) {
					System.out.println("文件关闭失败");
				}
			}
		}
	}

}
