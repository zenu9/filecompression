public interface CompressionStrategy {
    void compressFile(String inputFile, String outputFile);
    void decompressFile(String inputFile, String outputFile);
}
