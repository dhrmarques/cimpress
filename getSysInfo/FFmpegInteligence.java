public class FFmpegInteligence {
	public static float conversionGrade;
	//last conversion command used
	public static String ffmpegCommand = "-i input_file.avi -codec:v9 libvpx -quality good -cpu-used 0 -b:v 500k -qmin 10 -qmax 42 -maxrate 500k -bufsize 1000k -threads 4 -vf scale=-1 -codec:a libvorbis -b:a 128k output.webm";

	public static void main(String[] args){
	//input view output here
		conversionGrade = 5;
		if(conversionGrade == 5){
        		return;
		} else if (conversionGrade <= 4 && conversionGrade > 0){
			if(ffmpegCommand.indexOf("cpu-used 2") > 0) {
				ffmpegCommand.replace("cpu-used 2", "cpu-used 0");
				ffmpegCommand.replace("threads 2", "threads 0");
			} else if(ffmpegCommand.indexOf("cpu-used 0") > 0) {
				ffmpegCommand.replace("cpu-used 0", "cpu-used 2");
				ffmpegCommand.replace("threads 0", "threads 2");
			} else if(ffmpegCommand.indexOf("cpu-used 1") > 0) {
				ffmpegCommand.replace("cpu-used 1", "cpu-used 2");
				ffmpegCommand.replace("threads 1", "threads 2");
			}
			return;
		} else if (conversionGrade == 0){
			ffmpegCommand.replace("-good ", "-realtime ");
			ffmpegCommand.replace("-realtime", "-good");  	
			return;
		}
    	}
}
