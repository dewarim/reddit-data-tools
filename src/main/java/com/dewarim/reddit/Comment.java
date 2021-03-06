package com.dewarim.reddit;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * A Reddit comment.
 */
@JsonPropertyOrder(value = { "author", "name", "body", "author_flair_text", "gilded", "score_hidden", "score", "link_id", "retrieved_on",
                             "author_flair_css_class", "subreddit", "edited", "ups", "downs", "controversiality", "created_utc", "parent_id", "archived",
                             "subreddit_id", "id", "distinguished" })
public class Comment {

   public String  author;
   public String  name;
   public String  body;
   public String  author_flair_text;
   public Integer gilded           = 0;
   public boolean score_hidden;
   public Integer score            = 0;
   public String  link_id;
   public Long    retrieved_on     = 0L;
   public String  author_flair_css_class;
   public String  subreddit;
   public String  edited;
   public Integer ups              = 0;
   public Integer downs            = 0;
   public Integer controversiality = 0;
   public Long    created_utc      = 0L;
   public String  parent_id;
   public boolean archived;
   public String  subreddit_id;
   public String  id;
   public String  distinguished;

   @Override
   public String toString() {
      return "Comment{" + "author='" + author + '\'' + ", name='" + name + '\'' + ", body='" + body + '\'' + ", author_flair_text='" + author_flair_text + '\''
         + ", gilded=" + gilded + ", score_hidden=" + score_hidden + ", score=" + score + ", link_id='" + link_id + '\'' + ", retrieved_on=" + retrieved_on
         + ", author_flair_css_class='" + author_flair_css_class + '\'' + ", subreddit='" + subreddit + '\'' + ", edited=" + edited + ", ups=" + ups
         + ", downs=" + downs + ", controversiality=" + controversiality + ", created_utc=" + created_utc + ", parent_id='" + parent_id + '\'' + ", archived="
         + archived + ", subreddit_id='" + subreddit_id + '\'' + ", id='" + id + '\'' + ", distinguished='" + distinguished + '\'' + '}';
   }

   public String createLink() {
      return createLink(subreddit, link_id, id);
   }

   public static String createLink( String subreddit, String linkId, String commentId ) {
      if ( subreddit == null || linkId == null || commentId == null ) {
         return "[error]: can only create link from non-null fields.";
      }
      return String.format("http://www.reddit.com/r/%s/comments/%s/%s", subreddit, linkId.replace("t3_", ""), commentId);
   }
}
