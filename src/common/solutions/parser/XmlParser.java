package common.solutions.parser;

public interface XmlParser<T> {
    T parse(String file) throws Exception;
}
