package core.utilities.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {

	private Path path;

	public FileManager(String path) {
		this.path = Paths.get(path);
	}

	public void writeFile(String s) {
		try {
			createParentsDirectory();
			FileWriter fw = new FileWriter(this.path.toString(), false);
			fw.write(s);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createParentsDirectory() {
		if (!directoriExist()) {
			try {
				Files.createDirectories(path.getParent());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private boolean directoriExist() {
		return Files.exists(this.path.getParent(), LinkOption.NOFOLLOW_LINKS);
	}

	public String readFile() {
		StringBuffer ret = new StringBuffer();
		FileReader fr = null;
		BufferedReader buffer = null;
		try {
			fr = new FileReader(this.path.toString());
			buffer = new BufferedReader(fr);
			String s;
			while ((s = buffer.readLine()) != null) {
				ret.append(s);
				ret.append("\n");
			}
			buffer.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ret.toString();
	}

}
