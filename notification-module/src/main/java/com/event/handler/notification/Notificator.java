package com.event.handler.notification;

import java.util.List;

public interface Notificator<T> {
  void notifySubscribersWith(List<T> newElements);
}
