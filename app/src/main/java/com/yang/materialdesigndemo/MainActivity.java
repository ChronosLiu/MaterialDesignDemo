package com.yang.materialdesigndemo;

import android.app.FragmentTransaction;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private CoordinatorLayout coordinatorLayout;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerToggle.syncState();
        drawerLayout.setDrawerListener(drawerToggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_item_control:
                        getFragmentManager().beginTransaction().replace(
                                R.id.frame_layout,new ControlFragment()).commit();
                        toolbar.setTitle("Material控件");
                        break;
                    case R.id.navigation_item_example:

                        break;
                    case R.id.navigation_item_book:

                        getFragmentManager().beginTransaction().replace(
                                R.id.frame_layout,new BooksFragment()).commit();
                        toolbar.setTitle(R.string.title_book);
                        break;
                    case R.id.navigation_item_blog:

                        getFragmentManager().beginTransaction().replace(R.id.frame_layout,
                                BlogFragment.newInstance("http://blog.csdn.net/ly20116")).commit();
                        toolbar.setTitle("我的博客");
                        break;
                    case R.id.navigation_item_github:
                        getFragmentManager().beginTransaction().replace(R.id.frame_layout,
                                BlogFragment.newInstance("https://github.com/yang8218")).commit();
                        toolbar.setTitle("我的GitHub");
                        break;
                    case R.id.navigation_item_about:
                        getFragmentManager().beginTransaction().replace(R.id.frame_layout,
                                new AboutFragment()).commit();
                        toolbar.setTitle("关于");
                        break;

                }
                menuItem.setChecked(true);//菜单选中
                drawerLayout.closeDrawers();//退出侧滑菜单
                return true;
            }
        });

        getFragmentManager().beginTransaction().replace(
                R.id.frame_layout,new ControlFragment()).commit();
        toolbar.setTitle("Material控件");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
