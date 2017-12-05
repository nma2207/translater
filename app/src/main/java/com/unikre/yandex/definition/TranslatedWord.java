package com.unikre.yandex.definition;

//import lombok.Data;

import java.util.List;

public class TranslatedWord extends Word {

    public static class Definition {

        public static class Translation {

            public static class Example {
                private String src;
                private String translation;
                public void setSrc(String src){
                    this.src = src;
                }
                public void setTranslation(String translation){
                    this.translation=translation;
                }

                public String getSrc() {
                    return src;
                }

                public String getTranslation() {
                    return translation;
                }
            }

            private Word translatedWord;
            private List<String> srcMeans;
            private List<Example> examples;
            private List<Word> synonyms;
            public Word getTranslatedWord(){
                return  translatedWord;
            }
            public List<Word> getSynonyms(){
                return synonyms;
            }
            public List<String> getSrcMeans(){
                return  srcMeans;
            }

            public void setTranslatedWord(Word translatedWord) {
                this.translatedWord = translatedWord;
            }

            public void setSynonyms(List<Word> synonyms) {
                this.synonyms = synonyms;
            }

            public void setExamples(List<Example> examples) {
                this.examples = examples;
            }

            public List<Example> getExamples() {
                return examples;
            }

            public void setSrcMeans(List<String> srcMeans) {
                this.srcMeans = srcMeans;
            }
        }

        private Word srcWord;
        private List<Translation> translations;
        public Word getSrcWord(){
            return srcWord;
        }
        public List<Translation> getTranslations(){
            return translations;
        }

        public void setSrcWord(Word srcWord) {
            this.srcWord = srcWord;
        }

        public void setTranslations(List<Translation> translations) {
            this.translations = translations;
        }
    }

    private List<Definition> definitions;
    public List<Definition> getDefinitions(){
        return definitions;
    }

    public void setDefinitions(List<Definition> definitions) {
        this.definitions = definitions;
    }
}
