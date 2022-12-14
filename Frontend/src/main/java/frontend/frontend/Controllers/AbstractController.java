package frontend.frontend.Controllers;

import frontend.frontend.StageService;
import frontend.frontend.Utils.AuthenticatedUser;

public abstract class AbstractController {
    protected final AuthenticatedUser authenticatedUser = AuthenticatedUser.getInstance();
    protected final StageService stageService = StageService.getInstance();
}
