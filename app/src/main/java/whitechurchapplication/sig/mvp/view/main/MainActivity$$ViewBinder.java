// Generated code from Butter Knife. Do not modify!
package whitechurchapplication.sig.mvp.view.main;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends whitechurchapplication.sig.mvp.view.main.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558534, "method 'switch1'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.switch1();
        }
      });
    view = finder.findRequiredView(source, 2131558535, "method 'switch2'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.switch2();
        }
      });
    view = finder.findRequiredView(source, 2131558536, "method 'switch3'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.switch3();
        }
      });
    view = finder.findRequiredView(source, 2131558537, "method 'switch4'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.switch4();
        }
      });
    view = finder.findRequiredView(source, 2131558538, "method 'switch5'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.switch5();
        }
      });
  }

  @Override public void unbind(T target) {
  }
}
