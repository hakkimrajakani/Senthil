package com.redhat.engineering.plugins.actions;

import com.atlassian.jira.web.action.JiraWebActionSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vdedik@redhat.com
 */
public abstract class AbstractAction extends JiraWebActionSupport {

    private List<String> messages;

    public List<String> getMessages() {
        return messages;
    }

    public List<String> getFlushedMessages() {
        return getFlushedMessages(false);
    }

    public List<String> getFlushedMessages(Boolean keep) {
        List<String> currentMessages = getMessages();
        if (!keep) {
            this.messages = new ArrayList<String>();
        }
        return currentMessages;
    }

    public void addMessage(String message) {
        if (messages == null) {
            messages = new ArrayList<String>();
        }
        messages.add(message);
    }
}
