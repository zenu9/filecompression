public class Main {
    public static void main(String[] args) {
        CompressionStrategy strategy = new ZipCompressionStrategy();
        FileCompressor compressor = new FileCompressor(strategy);

        compressor.compressFile("C:\\Users\\mugiwara\\Documents\\Design Patterns\\FileCompression\\src\\Erzen.txt",
                "C:\\Users\\mugiwara\\Documents\\Design Patterns\\FileCompression\\src\\Erzen.zip");
        compressor.decompressFile("C:\\Users\\mugiwara\\Documents\\Design Patterns\\FileCompression\\src\\Erzen.zip",
                "C:\\Users\\mugiwara\\Documents\\Design Patterns\\FileCompression\\src\\Task.txt");

        CompressionStrategy nextStrategy = new GzipCompressionStrategy();
        FileCompressor nextCompressor = new FileCompressor(nextStrategy);

        nextCompressor.compressFile("C:\\Users\\mugiwara\\Documents\\Design Patterns\\FileCompression\\src\\Erzen.txt",
                "C:\\Users\\mugiwara\\Documents\\Design Patterns\\FileCompression\\src\\Erzen.gz");
        nextCompressor.decompressFile("C:\\Users\\mugiwara\\Documents\\Design Patterns\\FileCompression\\src\\Erzen.gz",
                "C:\\Users\\mugiwara\\Documents\\Design Patterns\\FileCompression\\src\\Task2.txt");
    }
}