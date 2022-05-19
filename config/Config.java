package config;

public class Config {
    public static final int FRAME_WIDTH = 1000;
    public static final int FRAME_HEIGHT = 600;
    public static final String ROOT_DIR = System.getProperty("user.dir");
    public static final String DIR_SEPARATOR = System.getProperty("file.separator");

    public static String getFilePath(String filename, String... folders) {
        String fullpath = ROOT_DIR;

        for(String folder : folders) {
            fullpath = fullpath + DIR_SEPARATOR + folder;
        }
        fullpath = fullpath + DIR_SEPARATOR + filename;
        return fullpath;
    }
}
