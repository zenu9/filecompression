public class FileCompressor {
    private CompressionStrategy compressionStrategy;

    public FileCompressor(CompressionStrategy strategy) {
        this.compressionStrategy = strategy;
    }

    public void compressFile(String inputFile, String outputFile) {
        compressionStrategy.compressFile(inputFile, outputFile);
    }

    public void decompressFile(String inputFile, String outputFile) {
        compressionStrategy.decompressFile(inputFile, outputFile);
    }
}
