package intelligentWebAlgorithms.examples.newsgroups.classification;

import intelligentWebAlgorithms.examples.newsgroups.core.NewsStory;
import intelligentWebAlgorithms.examples.newsgroups.core.NewsStoryGroup;

public interface ClassificationStrategy {
    public void assignTopicToCluster(NewsStoryGroup cluster);
    public void assignTopicToStory(NewsStory newsStory);
}