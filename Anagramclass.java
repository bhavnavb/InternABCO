import org.apache.hadoop.mapred.MapReduceBase;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import org.apache.hadoop.mapred.Reducer;
import java.util.StringTokenizer;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

public class Anagramclass {
                /**
                 * The Anagram mapper class gets a word as a line from the HDFS input and
                 * sorts the letters in the word and writes its back to the output collector
                 * as Key : sorted word (letters in the word sorted) Value: the word itself
                 * as the value. When the reducer runs then we can group anagrams together
                 * based on the sorted key.
                 */

                public static class AnagramMapper extends MapReduceBase implements
                                                Mapper<LongWritable, Text, Text, Text> {
                                private Text sortedText = new Text();
                                private Text orginalText = new Text();

                                @Override
                                public void map(LongWritable key, Text value,
                                                                OutputCollector<Text, Text> outputCollector, Reporter reporter)
                                                                throws IOException {

                                                String word = value.toString();
                                                char[] wordChars = word.toCharArray();
                                                Arrays.sort(wordChars);
                                                String sortedWord = new String(wordChars);
                                                sortedText.set(sortedWord);
                                                orginalText.set(word);
                                                outputCollector.collect(sortedText, orginalText);
                                }
                }

                /**
                 * The Anagram reducer class groups the values of the sorted keys that came
                 * in and checks to see if the values iterator contains more than one word.
                 * if the values contain more than one word we have spotted a anagram.
                 */

                public static class AnagramReducer extends MapReduceBase implements
                                                Reducer<Text, Text, Text, Text> {

                                private Text outputKey = new Text();
                                private Text outputValue = new Text();

                                @Override
                                public void reduce(Text anagramKey, Iterator<Text> anagramValues,
                                                                OutputCollector<Text, Text> results, Reporter reporter)
                                                                throws IOException {
                                                String output = "";
                                                while (anagramValues.hasNext()) {
                                                                Text anagam = anagramValues.next();
                                                                output = output + anagam.toString() + "~";
                                                }
                                                StringTokenizer outputTokenizer = new StringTokenizer(output, "~");
                                                if (outputTokenizer.countTokens() >= 2) {
                                                                output = output.replace("~", ",");
                                                                outputKey.set(anagramKey.toString());
                                                                outputValue.set(output);
                                                                results.collect(outputKey, outputValue);
                                                }

                                }

                }

                public static void main(String[] args) throws Exception {
                                JobConf conf = new JobConf(Anagramclass.class);
                                conf.setJobName("anagramcount");

                                conf.setOutputKeyClass(Text.class);
                                conf.setOutputValueClass(Text.class);

                                conf.setMapperClass(AnagramMapper.class);
                                // conf.setCombinerClass(AnagramReducer.class);
                                conf.setReducerClass(AnagramReducer.class);

                                conf.setInputFormat(TextInputFormat.class);
                                conf.setOutputFormat(TextOutputFormat.class);

                                FileInputFormat.setInputPaths(conf, new Path(args[0]));
                                FileOutputFormat.setOutputPath(conf, new Path(args[1]));

                                JobClient.runJob(conf);

                }

}
