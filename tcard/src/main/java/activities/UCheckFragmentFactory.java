package activities;

import androidx.annotation.NonNull;
import androidx.fragment.app.*;

public class UCheckFragmentFactory extends FragmentFactory {

    public UCheckFragmentFactory(DessertsRepository repository) {
        super();
        this.repository = repository;
    }

    @NonNull
    @Override
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className) {
        Class<? extends Fragment> fragmentClass = loadFragmentClass(classLoader, className);
        if (fragmentClass == DessertsFragment.class) {
            return new DessertsFragment(repository);
        } else {
            return super.instantiate(classLoader, className);
        }
    }
}