package es.avante.fullstackbootcamp.streamsdata;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Practica1 {
	
	static String folderPath = "src/main/resources/books";
	static String filePath = "src/main/resources/books/bookIndex.txt";
	
	public static void main(String [] args) {
		try {
			leerLinea();
			leerDatosFichero();
			leerDatosParallelStreams();
		}catch(IOException e) {}


	}
	
	private static void leerLinea() throws IOException{
		try (Stream<String> lineas = Files.lines(Path.of(filePath))){
			lineas.forEach(System.out::println);
		}
		
	}
	
	private static void leerDatosFichero() throws IOException{
		List<String> lista = Files.readAllLines(Path.of(filePath));
		Stream<String> lineas = lista.stream();
		lineas.forEach(System.out::println);
	}
	
	private static void leerDatosParallelStreams() throws IOException{
		List<String> lista = Files.readAllLines(Path.of(filePath));
		Stream<String> lineas = lista.parallelStream();
		lineas.forEach(System.out::println);
	}
	
	
}
